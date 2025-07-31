db = db.getSiblingDB('financas_db');

db.createUser({
  user: 'appuser',
  pwd: 'apppassword',
  roles: [
    { role: 'readWrite', db: 'financas_db' }
  ]
});