package com.febrie.demo_bk.dao;

import com.febrie.demo_bk.pojo.OperationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationLogDAO extends JpaRepository<OperationLog,Long> {
}
