-- Dumping database structure for beingexcellent
CREATE DATABASE IF NOT EXISTS beingexcellent /*!40100 DEFAULT CHARACTER SET latin1 */;
USE beingexcellent;


-- Dumping structure for table beingexcellent.users
CREATE TABLE IF NOT EXISTS t_user (
	id BIGINT(20) NOT NULL AUTO_INCREMENT,
	username varchar(60) NOT NULL,
	email varchar(60) NOT NULL,
	enabled bit(1) NOT NULL,
	password varchar(60) NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table beingexcellent.users: ~2 rows (approximately)
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO t_user (username,email, enabled, password) VALUES
 ('admin','admin', true, 'admin@123'),
 ('user','user', true, 'user@123');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;


-- Dumping structure for table beingexcellent.user_roles
CREATE TABLE IF NOT EXISTS t_user_role (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  role varchar(45) NOT NULL,
  user_id BIGINT(20) NOT NULL,
  PRIMARY KEY (id),
  KEY FK_user_has_role (user_id),
  CONSTRAINT FK_user_has_role FOREIGN KEY (user_id) REFERENCES t_user (id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table spring_social_db.user_roles: ~3 rows (approximately)
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO t_user_role (id, role, user_id) VALUES
 (1, 'ROLE_ADMIN', '1'),
 (2, 'ROLE_USER', '2'),
 (3, 'ROLE_USER', '1');
/*!40000 ALTER TABLE `t_user_role` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

