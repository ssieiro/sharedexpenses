package com.sharedexpenses.repository;

import com.sharedexpenses.domain.datamodels.FriendsGroup;
import com.sharedexpenses.repository.mysqlImp.FriendsGroupMybatisRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class MysqlDAOIT {


    @Autowired
    FriendsGroupMybatisRepository repository;

    @Test
    public void shouldGetGroups(){
        List<FriendsGroup> groups = repository.findAllGroups();
        assertThat(groups, is(notNullValue()));
    }


}
