SELECT * FROM Clientes_Con_Ventas

create procedure eliminarCliente @documento varchar(100),
								 @nombreO varchar(100) ,
								 @resultado varchar(100) OUTPUT
								 
as
begin try
	delete from Cliente where   DNI = @documento and NOMBRE=@nombreO
		set @resultado='ok, Cliente Eliminado'
end try

begin catch
	set @resultado = 'error, no se puedo Elimar al cliente'
end catch                                                                                                                                                                                                                                                                                                                                                                                