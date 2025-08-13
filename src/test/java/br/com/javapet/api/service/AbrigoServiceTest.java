package br.com.javapet.api.service;

import br.com.javapet.api.domain.Abrigo;
import br.com.javapet.api.dto.AbrigoRequest;
import br.com.javapet.api.dto.AbrigoResponse;
import br.com.javapet.api.mapper.AbrigoMapper;
import br.com.javapet.api.repository.AbrigoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AbrigoServiceTest {

    @InjectMocks
    private AbrigoService abrigoService;

    @Mock
    private AbrigoRepository abrigoRepository;

    @Mock
    private AbrigoMapper abrigoMapper;

    @Test
    public void deveRetornarListaDeAbrigosQuandoHouverAbrigos(){
        //Arrange
        Abrigo abrigo = new Abrigo("Abrigo teste", "11999998888", "abrigoteste@email.com");
        List<Abrigo> listaAbrigos = List.of(abrigo);

        AbrigoResponse abrigoResponse = new AbrigoResponse(null, "Abrigo Teste", "11999998888", "teste@email.com");
        List<AbrigoResponse> listaDeResponseEsperada = List.of(abrigoResponse);

        when(abrigoRepository.findAll()).thenReturn(listaAbrigos);
        when(abrigoMapper.toResponseList(listaAbrigos)).thenReturn(listaDeResponseEsperada);

        //Act
        List<AbrigoResponse> resultado = abrigoService.listar();

        //Assert
        Assertions.assertEquals(listaDeResponseEsperada, resultado);

        verify(abrigoRepository).findAll();
        verify(abrigoMapper).toResponseList(listaAbrigos);
    }

    @Test
    public void deveRetornarListaVaziaQuandoNaoHouverAbrigos() {
        when(abrigoRepository.findAll()).thenReturn(Collections.emptyList());
        when(abrigoMapper.toResponseList(Collections.emptyList())).thenReturn(Collections.emptyList());

        List<AbrigoResponse> resultado = abrigoService.listar();

        Assertions.assertTrue(resultado.isEmpty());

        verify(abrigoRepository).findAll();
        verify(abrigoMapper).toResponseList(Collections.emptyList());
    }

    @Test
    public void deveChamarMetodoSaveDoRepositorioAoCadastrar(){
        AbrigoRequest abrigoRequest = new AbrigoRequest("Abrigo Novo", "21988887777", "novoteste@email.com");
        Abrigo abrigoMapeado = new Abrigo("Abrigo Novo", "21988887777", "novoteste@email.com");

        when(abrigoMapper.toEntity(abrigoRequest)).thenReturn(abrigoMapeado);

        abrigoService.cadastrar(abrigoRequest);

        verify(abrigoRepository).save(abrigoMapeado);
    }
}
