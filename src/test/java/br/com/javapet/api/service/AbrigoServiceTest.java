package br.com.javapet.api.service;

import br.com.javapet.api.domain.Abrigo;
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

    @Test
    public void deveRetornarListaDeAbrigosQuandoHouverAbrigos(){
        Abrigo abrigo = new Abrigo("Abrigo teste", "11999998888", "abrigoteste@email.com");
        List<Abrigo> listaEsperada = List.of(abrigo);

        when(abrigoRepository.findAll()).thenReturn(listaEsperada);

        List<Abrigo> listaRetornada = abrigoService.listar();

        Assertions.assertEquals(listaEsperada, listaRetornada);
    }

    @Test
    public void deveRetornarListaVaziaQuandoNaoHouverAbrigos() {
        when(abrigoRepository.findAll()).thenReturn(Collections.emptyList());

        List<Abrigo> listaRetornada = abrigoService.listar();


        Assertions.assertTrue(listaRetornada.isEmpty());
    }

    @Test
    public void deveChamarMetodoSaveDoRepositorioAoCadastrar(){
        Abrigo abrigoParaCadastrar = new Abrigo("Abrigo Novo", "21988887777", "novoteste@email.com");

        abrigoService.cadastrar(abrigoParaCadastrar);

        verify(abrigoRepository, times(1)).save(abrigoParaCadastrar);
    }
}
