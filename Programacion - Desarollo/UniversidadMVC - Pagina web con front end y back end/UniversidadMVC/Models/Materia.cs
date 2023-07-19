using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UniversidadMVC.Models
{

    public class Materia
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int Id { get; set; }
        public string Nombre { get; set; }
      
        [ForeignKey("Carrera")]      
        public int CarreraId { get; set; } 

        public virtual Carrera Carrera { get; set; } 

        public virtual List<Inscripcion> Inscriptos { get; set; }

        public Materia() { }
    }



}
