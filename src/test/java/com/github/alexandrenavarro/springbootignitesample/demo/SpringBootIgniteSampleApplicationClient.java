package com.github.alexandrenavarro.springbootignitesample.demo;

import com.github.alexandrenavarro.springbootignitesample.dto.Price;
import lombok.extern.slf4j.Slf4j;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.cache.configuration.CacheEntryListenerConfiguration;
import javax.cache.configuration.Factory;
import javax.cache.configuration.FactoryBuilder;
import javax.cache.configuration.MutableCacheEntryListenerConfiguration;
import javax.cache.event.*;

@SpringBootApplication
@Slf4j
public class SpringBootIgniteSampleApplicationClient implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootIgniteSampleApplicationClient.class, args);
	}

	@Autowired
	private Ignite ignite;

	@Override
	public void run(String... args) throws Exception {
		IgniteCache<Long, Price> cache = ignite.getOrCreateCache(
				"PriceCache");
		log.info("priceRepository.get(1():{}", cache.get(1L));

		while (true) {
			Thread.sleep(10000);
			log.info("priceRepository.get(1():{}", cache.get(1L));
		}
	}




}

