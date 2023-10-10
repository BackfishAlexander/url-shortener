package com.alexbackfish.urlshortenerbackend.Repositories;

import com.alexbackfish.urlshortenerbackend.Entities.URLEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMainRepository extends JpaRepository<URLEntry, String> {
}
