# Test-jpa

## Persistence.xml

**pour reg�n�rer automatiquement le schema � chaque red�marrage de l�application:**
<property name="javax.persistence.schema-generation.database.action" value="drop-and-create"/>

##

**Cette propri�t� ne cr�� que les nouvelles tables apr�s chaque red�marrage:**


<property name="hibernate.hbm2ddl.auto" value="update"/>

##

**Cette propri�t� d�sactive l�auto-d�tection des entit�s dans les packages du projet:**


<property name="hibernate.archive.autodetection" value="" />


*Attention cette propri�t� s�utilise avec la balise class pour lister les entit�s manuellement (cf exemple ci-dessous).*

##