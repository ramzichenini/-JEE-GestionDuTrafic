package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
