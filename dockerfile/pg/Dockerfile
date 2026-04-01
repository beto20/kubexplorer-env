FROM postgres:16

ENV POSTGRES_DB=test
ENV POSTGRES_USER=admin
ENV POSTGRES_PASSWORD=admin123

EXPOSE 5432

# Copiar scripts de inicialización opcionales
# Todo archivo .sql o .sh dentro de este directorio se ejecuta
# automáticamente la primera vez que se crea la base de datos
#COPY init.sql /docker-entrypoint-initdb.d/