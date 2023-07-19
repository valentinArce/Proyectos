select * from arbol
select nombre,costomantenimiento from arbol

select * from arbol where
codestacionflora='PRI'

select * from arbol where
codestacionflora='PRI' OR codEstacionFlora='VER'

select nombre,costomantenimiento from arbol where
codestacionflora='PRI' OR codEstacionFlora='VER'

select codarbol + nombre Arbol ,costomantenimiento from arbol where
codestacionflora='PRI' OR codEstacionFlora='VER'

select codarbol +' '+ nombre Arbol ,CostoMantenimiento as Costo from arbol where
codestacionflora='PRI' OR codEstacionFlora='VER'

select codarbol +' '+ nombre Arbol ,CostoMantenimiento as Costo, 
costomantenimiento*1.2  FuturoCosto from arbol where
codestacionflora='PRI' OR codEstacionFlora='VER'

select codarbol +' '+ nombre Arbol ,CostoMantenimiento as Costo, 
costomantenimiento*1.2  FuturoCosto 
from 
	arbol 
where
	costomantenimiento>1000

select codarbol +' '+ nombre Arbol ,CostoMantenimiento as Costo, 
costomantenimiento*1.2  FuturoCosto 
from 
	arbol 
where
	costomantenimiento between 8500 and 15000

