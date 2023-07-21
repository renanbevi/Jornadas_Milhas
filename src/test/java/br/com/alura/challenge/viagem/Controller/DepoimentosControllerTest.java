package br.com.alura.challenge.viagem.Controller;

import br.com.alura.challenge.viagem.model.dto.DadosCadastroDepoimento;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("teste")
@AutoConfigureJsonTesters //teste com json
@AutoConfigureMockMvc //teste de MOCK
@SpringBootTest
class DepoimentosControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private JacksonTester<DadosCadastroDepoimento> dadosCadastroDepoimentoJacksonTester;



    @Test
    @DisplayName("Ao realizar o cadastro devera validar o status 200 http")
    @WithMockUser
    void cadastrarDepoimento() throws Exception {
        var response = mockMvc
                .perform(post("/depoimentos")
                                .contentType(MediaType.APPLICATION_JSON)//leva o cabeçalho com o valor json
                                .content(dadosCadastroDepoimentoJacksonTester.write(
                                        new DadosCadastroDepoimento("Renanzito","http://fotooriginal.com.br/foto.gif","Que lugar maravilhoso")
                                ).getJson())
                        //getJason converte o objeto para String Jason
                )
                //performa uma requisição em nossa api post devido ao metodo ser um POST
                .andReturn().getResponse();

        //Assert recebendo o status do response  sucess  que é o código 204.
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    }
}