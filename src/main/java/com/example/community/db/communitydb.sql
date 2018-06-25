/*用户*/
CREATE TABLE `user` (
  `u_id` int(5) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(15) NOT NULL,
  `u_password` varchar(15) NOT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*朋友圈*/
CREATE TABLE `moments` (
  `m_id` int(5) NOT NULL AUTO_INCREMENT,
  `u_id` int(5) NOT NULL,
  `m_time` datetime NOT NULL,
  `m_text` varchar(255) NOT NULL,
  PRIMARY KEY (`m_id`),
  KEY `m_u_id` (`u_id`),
  CONSTRAINT `m_u_id` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*点赞*/
CREATE TABLE `favorite` (
  `u_id` int(5) NOT NULL,
  `m_id` int(5) NOT NULL,
  KEY `f_u_id` (`u_id`),
  KEY `f_m_id` (`m_id`),
  CONSTRAINT `f_m_id` FOREIGN KEY (`m_id`) REFERENCES `moments` (`m_id`),
  CONSTRAINT `f_u_id` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
