package com.ffernandez.price.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface SpringDataPriceRepository extends JpaRepository<PriceJpaEntity, Long> {
    List<PriceJpaEntity> findByProductIdAndBrandId(Long productId, Long brandId);
}
