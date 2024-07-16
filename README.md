# Sistema de Gerenciamento de Doações

O Desafio consistiu em criar é um projeto de um sistema de gerenciamento de doações, desenvolvido em Java com uso do Hibernate e JPA para persistência de dados. O sistema permite o gerenciamento de abrigos, centros de distribuição e doações, possibilitando a criação, edição, listagem e remoção de registros, bem como a associação de doações a centros de distribuição e abrigos.


## Como Executar

1. **Pré-requisitos**: ter JDK instalado em sua máquina, usar eclipse.

2. **Configuração do Banco de Dados**: Ajuste o arquivo `persistence.xml` conforme necessário para apontar para o seu banco de dados.

3. **Executar a Aplicação**: Compile e execute a aplicação a partir da classe `main.Menu`.

## Configuração do Banco de Dados

É possivel configurar `persistence.xml` colcocando a porta correta do local host do mysql que é possivel acessar ao executar o xampp e colcar o mesmo "name" de persistence em util/JPAUtil.java

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
	version="2.1">

	<persistence-unit name="persistence-unit-name">
		<provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
		<properties>
			<property name="javax.persistence.jdbc.driver"
				value="com.mysql.cj.jdbc.Driver" />
			<property name="javax.persistence.jdbc.url"
				value="jdbc:mysql://localhost:3307/NOME-BANCO?useSSL=false&amp;serverTimezone=UTC" />
			<property name="javax.persistence.jdbc.user" value="root" /> //SEU USER
			<property name="javax.persistence.jdbc.password" value="" /> //SUA SENHA

			<property name="hibernate.dialect"
				value="org.hibernate.dialect.MySQL8Dialect" />
			<property name="hibernate.show_sql" value="true" />
			<property name="hibernate.hbm2ddl.auto" value="update" />
		</properties>
	</persistence-unit>
</persistence>
```
```JPAUtil

public class JPAUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit-name");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public static void close() {
        emf.close();
    }
}

```

## Projeto Maven

O arquivo `pom.xml` deve incluir as dependências necessárias para o Hibernate, JPA e o driver do MySQL. Aqui está um exemplo de configuração do `pom.xml`:

## Persistência de Dados com XAMPP

Para facilitar a configuração do ambiente de desenvolvimento, você pode utilizar o XAMPP, que fornece uma instalação fácil do Apache, MySQL, PHP e Perl. Certifique-se de ter o XAMPP instalado e configurado em sua máquina. Crie um banco de dados no MySQL através do phpMyAdmin, que é fornecido com o XAMPP.
