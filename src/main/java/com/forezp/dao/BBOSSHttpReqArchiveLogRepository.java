package com.forezp.dao;

import com.forezp.entity.BBOSSHttpReqArchiveLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jh on 2017/7/25.
 */
@Repository
public interface BBOSSHttpReqArchiveLogRepository extends JpaRepository<BBOSSHttpReqArchiveLog, String> {
}
