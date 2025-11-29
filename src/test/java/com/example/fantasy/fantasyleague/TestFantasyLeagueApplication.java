package com.example.fantasy.fantasyleague;

import org.springframework.boot.SpringApplication;

public class TestFantasyLeagueApplication {

    public static void main(String[] args) {
        SpringApplication.from(FantasyLeagueApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
