package com.sharedexpenses.repository;

import org.junit.jupiter.api.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MysqlDAOIT {

    @Test
    public void shouldAnything(){
        String hola = "Hola";
        assertThat(hola, is("Hola"));
    }

}
