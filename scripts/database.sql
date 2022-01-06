create database carsalesdev;
create user 'carsales'@'localhost' identified by 'rdcarsales';
create user 'carsales'@'%' identified by 'rdcarsales';
grant all privileges on carsalesdev.* to 'carsales'@'localhost';
grant all privileges on carsalesdev.* to 'carsales'@'%';
flush privileges;
