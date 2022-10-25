package com.sumit.cachebeg.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sumit.cachebeg.model.Address;
import com.sumit.cachebeg.model.Major;
import com.sumit.cachebeg.model.Student;

@Service
public class APIService {

	@Cacheable(value = "student-cache",key="'student-key'+#studentId")
	public Optional<Student> fetchStudent(String studentId) throws InterruptedException {
		Thread.sleep(4000);
		return Arrays
				.asList(new Student("19VC21", "John", "Wayne", "11",
						new Address("12A", "Bay Avenue", "SanFrancisco", "CA", "91234"), Major.MATHS),
						new Student("19VC22", "Mary", "Jane", "11",
								new Address("10A", "Cross Avenue", "SanFrancisco", "CA", "91238"), Major.CHEMISTRY),
						new Student("19VC23", "Peter", "Parker", "11",
								new Address("1A", "First Avenue", "SanFrancisco", "CA", "91934"), Major.PHYSICS))
				.stream().filter(t -> t.getId().equalsIgnoreCase(studentId)).findFirst();
	}
}
