# Test-jpa

## Persistence.xml

**pour regénérer automatiquement le schema à chaque redémarrage de l’application:**

```sh
<property name="javax.persistence.schema-generation.database.action" value="drop-and-create"/>
```

##

**Cette propriété ne créé que les nouvelles tables après chaque redémarrage:**

```sh
<property name="hibernate.hbm2ddl.auto" value="update"/>
```

##

**Cette propriété désactive l’auto-détection des entités dans les packages du projet:**

```sh
<property name="hibernate.archive.autodetection" value="" />
```


*Attention cette propriété s’utilise avec la balise class pour lister les entités manuellement (cf exemple ci-dessous).*

##

**desactiver l'autodetection des classes de type @Entity**

```sh
<property name="hibernate.archive.autodetection" value=""/>
```

##

**Activation de la génération des tables manquantes uniquement**

```sh
<property name="hibernate.hbm2ddl.auto" value="update" />
```

##

**Drop and create à chaque redémarrage**

```sh
<property name="javax.persistence.schema-generation.database.action" value="drop-and-create" />
```

##

**Affichage des requêtes SQL**

```sh
<property name="hibernate.show_sql" value="true" />
```

##

**Paramètres d'accès à la BDD**

```sh
<property name="javax.persistence.jdbc.url" value="jdbc:mariadb://localhost:3306/banque" />
<property name="javax.persistence.jdbc.user" value="root" />
<property name="javax.persistence.jdbc.password" value="" />
<property name="javax.persistence.jdbc.driver" value="org.mariadb.jdbc.Driver" />
```

##