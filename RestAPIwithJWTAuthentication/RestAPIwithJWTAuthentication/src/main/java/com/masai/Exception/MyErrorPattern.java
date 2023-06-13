package com.masai.Exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyErrorPattern {

	private LocalDateTime localDateTime;
	private String messeage;
	private String description;
}
