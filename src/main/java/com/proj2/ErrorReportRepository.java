package com.proj2;
import entity.ErrorReportEntity;
import org.springframework.data.repository.CrudRepository;

public interface ErrorReportRepository extends CrudRepository<ErrorReportEntity, Long> {
}
