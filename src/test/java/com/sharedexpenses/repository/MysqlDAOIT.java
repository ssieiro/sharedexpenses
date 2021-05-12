package com.sharedexpenses.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


//inyectar repositorio
@SpringBootTest
public class MysqlDAOIT {

    @Test
    public void shouldAnything(){
        String hola = "Hola";
        assertThat(hola, is("Hola"));
    }

}
