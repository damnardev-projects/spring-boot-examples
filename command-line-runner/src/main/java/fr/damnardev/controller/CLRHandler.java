package fr.damnardev.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CLRHandler implements CommandLineRunner {

	@Override
	public void run(String... args) {
		log.info("Command line runner started");
	}

}
