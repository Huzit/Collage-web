package com.n2015942043.main;

import com.n2015942043.main.domain.Basic;
import com.n2015942043.main.domain.Profile;
import com.n2015942043.main.repository.BasicRepository;
import com.n2015942043.main.repository.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
	@Bean
	public CommandLineRunner runner(BasicRepository basicRepository) {
		return (args) -> {
			basicRepository.save(Basic.builder()
					.email("hong@gmail.com")
					.label("CEO")
					.name("홍길동")
					.phone("012-123-4567")
					.build());
			basicRepository.save(Basic.builder()
					.email("jang@gmail.com")
					.label("CFO")
					.name("장길산")
					.phone("123-456-7890")
					.build());
			basicRepository.save(Basic.builder()
					.email("chun@gmail.com")
					.label("CTO")
					.name("춘향이")
					.phone("234-567-8901")
					.build());
		};
	}

	@Bean
	public CommandLineRunner runner1(ProfileRepository profileRepository){
		return (args) -> {

			profileRepository.save(Profile.builder()
					.network("퍼렁새")
					.username("@home")
					.url("https://www.twitter.com/@home")
					.createDat(LocalDateTime.now())
					.build());
			profileRepository.save(Profile.builder()
					.network("얼굴책")
					.username("@home")
					.url("https://www.facebook.com/@home")
					.createDat(LocalDateTime.now())
					.build());
			profileRepository.save(Profile.builder()
					.network("인스타그램")
					.username("@home")
					.url("https://www.instergram.com/@home")
					.createDat(LocalDateTime.now())
					.build());
		};
	}
}
