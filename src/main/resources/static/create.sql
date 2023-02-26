create database notes;
create user 'notes'@'%' identified by 'notes';
grant all on notes.* to 'notes'@'%';