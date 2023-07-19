USE [TPPROFE]
GO

/****** Object:  Table [dbo].[Arbol]    Script Date: 10/9/2022 5:08:19 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Arbol](
	[CodArbol] [varchar](10) NOT NULL,
	[Nombre] [varchar](100) NULL,
	[CodEstacionFlora] [char](3) NULL,
	[CodEstacionPoda] [char](3) NULL,
	[CostoMantenimiento] [money] NULL,
 CONSTRAINT [PK_Arbol] PRIMARY KEY CLUSTERED 
(
	[CodArbol] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[ArbolParque]    Script Date: 10/9/2022 5:08:19 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[ArbolParque](
	[NroParque] [int] NOT NULL,
	[CodArbol] [varchar](10) NOT NULL,
	[Cantidad] [int] NULL,
 CONSTRAINT [PK_ArbolParque] PRIMARY KEY CLUSTERED 
(
	[NroParque] ASC,
	[CodArbol] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Cuidador]    Script Date: 10/9/2022 5:08:19 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Cuidador](
	[DniCuidador] [varchar](20) NOT NULL,
	[Nombre] [varchar](100) NULL,
	[Apellido] [varchar](100) NULL,
 CONSTRAINT [PK_Cuidador] PRIMARY KEY CLUSTERED 
(
	[DniCuidador] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Estacion]    Script Date: 10/9/2022 5:08:19 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Estacion](
	[CodEstacion] [char](3) NOT NULL,
	[Nombre] [varchar](30) NULL,
	[MesDesde] [int] NULL,
	[MesHasta] [int] NULL,
 CONSTRAINT [PK_Estacion] PRIMARY KEY CLUSTERED 
(
	[CodEstacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Mantenimiento]    Script Date: 10/9/2022 5:08:19 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Mantenimiento](
	[idMantenimiento] [int] IDENTITY(1,1) NOT NULL,
	[NroParque] [int] NOT NULL,
	[FechaHora] [datetime] NOT NULL,
	[Observaciones] [varchar](max) NULL,
 CONSTRAINT [PK_Mantenimiento_1] PRIMARY KEY CLUSTERED 
(
	[idMantenimiento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Parque]    Script Date: 10/9/2022 5:08:19 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Parque](
	[NroParque] [int] NOT NULL,
	[Nombre] [varchar](100) NULL,
	[Direccion] [varchar](100) NULL,
	[DniCuidador] [varchar](20) NULL,
 CONSTRAINT [PK_Parque] PRIMARY KEY CLUSTERED 
(
	[NroParque] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[TelefonoCuidador]    Script Date: 10/9/2022 5:08:19 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[TelefonoCuidador](
	[idTelefonoCuidador] [int] IDENTITY(1,1) NOT NULL,
	[DniCuidador] [varchar](20) NOT NULL,
	[Telefono] [varchar](100) NOT NULL,
 CONSTRAINT [PK_TelefonoCuidador_1] PRIMARY KEY CLUSTERED 
(
	[idTelefonoCuidador] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Arbol]  WITH CHECK ADD  CONSTRAINT [FK_Arbol_Estacion] FOREIGN KEY([CodEstacionFlora])
REFERENCES [dbo].[Estacion] ([CodEstacion])
GO

ALTER TABLE [dbo].[Arbol] CHECK CONSTRAINT [FK_Arbol_Estacion]
GO

ALTER TABLE [dbo].[Arbol]  WITH CHECK ADD  CONSTRAINT [FK_Arbol_Estacion1] FOREIGN KEY([CodEstacionPoda])
REFERENCES [dbo].[Estacion] ([CodEstacion])
GO

ALTER TABLE [dbo].[Arbol] CHECK CONSTRAINT [FK_Arbol_Estacion1]
GO

ALTER TABLE [dbo].[ArbolParque]  WITH CHECK ADD  CONSTRAINT [FK_ArbolParque_Arbol] FOREIGN KEY([CodArbol])
REFERENCES [dbo].[Arbol] ([CodArbol])
GO

ALTER TABLE [dbo].[ArbolParque] CHECK CONSTRAINT [FK_ArbolParque_Arbol]
GO

ALTER TABLE [dbo].[ArbolParque]  WITH CHECK ADD  CONSTRAINT [FK_ArbolParque_Parque] FOREIGN KEY([NroParque])
REFERENCES [dbo].[Parque] ([NroParque])
GO

ALTER TABLE [dbo].[ArbolParque] CHECK CONSTRAINT [FK_ArbolParque_Parque]
GO

ALTER TABLE [dbo].[Mantenimiento]  WITH CHECK ADD  CONSTRAINT [FK_Mantenimiento_Parque] FOREIGN KEY([NroParque])
REFERENCES [dbo].[Parque] ([NroParque])
GO

ALTER TABLE [dbo].[Mantenimiento] CHECK CONSTRAINT [FK_Mantenimiento_Parque]
GO

ALTER TABLE [dbo].[Parque]  WITH CHECK ADD  CONSTRAINT [FK_Parque_Cuidador1] FOREIGN KEY([DniCuidador])
REFERENCES [dbo].[Cuidador] ([DniCuidador])
GO

ALTER TABLE [dbo].[Parque] CHECK CONSTRAINT [FK_Parque_Cuidador1]
GO

ALTER TABLE [dbo].[TelefonoCuidador]  WITH CHECK ADD  CONSTRAINT [FK_TelefonoCuidador_Cuidador] FOREIGN KEY([DniCuidador])
REFERENCES [dbo].[Cuidador] ([DniCuidador])
GO

ALTER TABLE [dbo].[TelefonoCuidador] CHECK CONSTRAINT [FK_TelefonoCuidador_Cuidador]
GO


