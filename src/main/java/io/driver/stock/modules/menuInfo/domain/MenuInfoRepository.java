package io.driver.stock.modules.menuInfo.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.driver.stock.modules.menu.domain.Menu;

@Repository
public interface MenuInfoRepository extends JpaRepository<MenuInfo, Long> {
	List<MenuInfo> findAllByMenu(Menu menu);
}
