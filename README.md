# Test-jpa

## Persistence.xml

**pour reg�n�rer automatiquement le schema � chaque red�marrage de l�application:**

```sh
<property name="javax.persistence.schema-generation.database.action" value="drop-and-create"/>
```

##

**Cette propri�t� ne cr�� que les nouvelles tables apr�s chaque red�marrage:**

```sh
<property name="hibernate.hbm2ddl.auto" value="update"/>
```

##

**Cette propri�t� d�sactive l�auto-d�tection des entit�s dans les packages du projet:**

```sh
<property name="hibernate.archive.autodetection" value="" />
```


*Attention cette propri�t� s�utilise avec la balise class pour lister les entit�s manuellement (cf exemple ci-dessous).*

##

**desactiver l'autodetection des classes de type @Entity**

```sh
<property name="hibernate.archive.autodetection" value=""/>
```

##

**Activation de la g�n�ration des tables manquantes uniquement**

```sh
<property name="hibernate.hbm2ddl.auto" value="update" />
```

##

**Drop and create � chaque red�marrage**

```sh
<property name="javax.persistence.schema-generation.database.action" value="drop-and-create" />
```

##

**Affichage des requ�tes SQL**

```sh
<property name="hibernate.show_sql" value="true" />
```

##

**Param�tres d'acc�s � la BDD**

```sh
<property name="javax.persistence.jdbc.url" value="jdbc:mariadb://localhost:3306/banque" />
<property name="javax.persistence.jdbc.user" value="root" />
<property name="javax.persistence.jdbc.password" value="" />
<property name="javax.persistence.jdbc.driver" value="org.mariadb.jdbc.Driver" />
```

##