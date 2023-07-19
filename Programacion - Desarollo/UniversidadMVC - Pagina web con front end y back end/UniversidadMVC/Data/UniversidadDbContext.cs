using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;
using UniversidadMVC.Models;

namespace UniversidadMVC.Data
{

    public class UniversidadDbContext : IdentityDbContext<Usuario, Role, string>
    {

        public UniversidadDbContext() { }
        public UniversidadDbContext(DbContextOptions<UniversidadDbContext> options) : base(options) { }
      
        public DbSet<Carrera> Carreras { get; set; }
        public DbSet<Inscripcion> Inscripciones { get; set; }
        public DbSet<Materia> Materias { get; set; }
     
    }

}
    
   

