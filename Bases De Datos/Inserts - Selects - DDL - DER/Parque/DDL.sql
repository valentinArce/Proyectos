USE [TP]
GO

/****** Object:  Table [dbo].[Arbol]    Script Date: 06/10/2022 10:45:40 ******/
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

/****** Object:  Table [dbo].[ArbolParque]    Script Date: 06/10/2022 10:45:40 ******/
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

/****** Object:  Table [dbo].[Cuidador]    Script Date: 06/10/2022 10:45:40 ******/
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

/****** Object:  Table [dbo].[Estacion]    Script Date: 06/10/2022 10:45:40 ******/
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

/****** Object:  Table [dbo].[Mantenimiento]    Script Date: 06/10/2022 10:45:40 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Mantenimiento](
	[NroParque] [int] NOT NULL,
	[FechaHora] [datetime] NOT NULL,
	[Observaciones] [varchar](max) NULL,
 CONSTRAINT [PK_Mantenimiento] PRIMARY KEY CLUSTERED 
(
	[NroParque] ASC,
	[FechaHora] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Parque]    Script Date: 06/10/2022 10:45:40 ******/
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

/****** Object:  Table [dbo].[TelefonoCuidador]    Script Date: 06/10/2022 10:45:40 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[TelefonoCuidador](
	[DniCuidador] [varchar](20) NOT NULL,
	[Telefono] [varchar](100) NOT NULL,
 CONSTRAINT [PK_TelefonoCuidador] PRIMARY KEY CLUSTERED 
(
	[DniCuidador] ASC,
	[Telefono] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


