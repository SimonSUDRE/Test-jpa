# Test-jpa

## Persistence.xml

**pour regénérer automatiquement le schema à chaque redémarrage de l’application:**
<property name="javax.persistence.schema-generation.database.action" value="drop-and-create"/>

##

**Cette propriété ne créé que les nouvelles tables après chaque redémarrage:**


<property name="hibernate.hbm2ddl.auto" value="update"/>

##

**Cette propriété désactive l’auto-détection des entités dans les packages du projet:**


<property name="hibernate.archive.autodetection" value="" />


*Attention cette propriété s’utilise avec la balise class pour lister les entités manuellement (cf exemple ci-dessous).*

##