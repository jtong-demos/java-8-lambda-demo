package com.thoughtworks.java8.lambda.jtong;/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


@DisplayName("java 8 lambda demo suite")
class LibraryTest {

    @BeforeAll
    static void initTestEnv() {
    }

    @BeforeEach
    void initEveryMethod() {
    }

    @Test
    @DisplayName("Predicate accept 1 argument, return boolean")
    void testPredicate() {
        Predicate<Player> playerIsAlive = p -> p.getHp() > 0;
        Player zhangsan = new Player("张三", 100, 10);

        assertThat(playerIsAlive.test(zhangsan), is(true));
        assertThat(playerIsAlive.negate().test(zhangsan), is(false));
    }

    @Test
    @DisplayName("Predicate can only 'and' Predicate")
    void testPredicateAnd() {
        Predicate<Player> playerIsAlive = p -> p.getHp() > 0;
        Predicate<Player> playerHasName = p -> p.getName() != null;
        Player zhangsan = new Player("张三", 100, 10);

        Player johnDoe = new Player(null, 100, 5);

        assertThat(playerIsAlive.and(playerHasName).test(zhangsan), is(true));
        assertThat(playerIsAlive.and(playerHasName).test(johnDoe), is(false));
    }

    @Test
    @DisplayName("BiPredicate accept 2 arguments, return boolean")
    void testBiPredicate() {
        BiPredicate<Player, Player> AP_of_playerA_bigger_than_playerB = (playerA, playerB) -> playerA.getAp() > playerB.getAp();
        Player zhangsan = new Player("张三", 100, 10);
        Player lisi = new Player("李四", 100, 8);

        assertThat(AP_of_playerA_bigger_than_playerB.test(zhangsan, lisi), is(true));
    }


    @Test
    @DisplayName("Function need two generic params, 1 for argument, 1 for result")
    void testFunction() {
        Function<Player, String> introduceMySelf = (player) ->  "姓名："+player.getName() +"，HP：" + player.getHp() ;
        Player zhangsan = new Player("张三", 100, 10);

        assertThat(introduceMySelf.apply(zhangsan), is("姓名：张三，HP：100"));
    }

    @Test
    @DisplayName("Function identity do nothing")
    void testFunction_identity() {
        Function<Player,Player> doNothing = Function.identity() ;
        Player zhangsan = new Player("张三", 100, 10);

        assertThat(doNothing.apply(zhangsan) == zhangsan, is(true));
    }


    @Test
    @DisplayName("Function compose combine before")
    void testFunction_compose() {
        Function<Integer,Integer> increase = i -> i+1;
        Function<Integer, Integer> doubleIt = i -> i*2;


        assertThat(increase.compose(doubleIt).apply(1), is(3));//(1*2)+1
    }


    @Test
    @DisplayName("Function andThen combine after")
    void testFunction_andThen() {
        Function<Integer,Integer> increase = i -> i+1;
        Function<Integer, Integer> doubleIt = i -> i*2;


        assertThat(increase.andThen(doubleIt).apply(1), is(4));//(1+1)*2
    }


}