package com.sharedexpenses.repository.mysqlImp.mappers;

import com.sharedexpenses.domain.Payment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PaymentMapper {

    //SELECT ALL
    @Select("select * from payment")
    @Results({
            @Result(property = "friendId", column = "friend_id")
    })
    List<Payment> findAllPayments();

    //SELECT BY ID
    @Select("SELECT * FROM payment WHERE id = #{id}")
    @Results({
            @Result(property = "friendId", column = "friend_id")
    })
    Payment findPaymentById(long id);

    //INSERT
    @Insert("INSERT INTO payment(concept, amount, date, friend_id) " +
            " VALUES (#{concept}, #{amount}, #{date}, #{friendId})")
    @SelectKey(keyColumn="id", keyProperty="id", resultType=long.class, before=false, statement="select last_insert_id()")
    @Results({
            @Result(property = "friendId", column = "friend_id")
    })
    void insertPayment(Payment payment);

    //DELETE
    @Delete("DELETE FROM payment WHERE id = #{id}")
    @Results({
            @Result(property = "friendId", column = "friend_id")
    })
    void deletePaymentById(long id);
}
