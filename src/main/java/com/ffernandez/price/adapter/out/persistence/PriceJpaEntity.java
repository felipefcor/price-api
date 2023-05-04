package com.ffernandez.price.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceJpaEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Long brandId;
	@Column
	private LocalDateTime startDate;
	@Column
	private LocalDateTime endDate;
	@Column
	private Double rate;
	@Column
	private Long productId;
	@Column
	private Integer priority;
	@Column
	private Double price;
	@Column
	private String currency;
}
