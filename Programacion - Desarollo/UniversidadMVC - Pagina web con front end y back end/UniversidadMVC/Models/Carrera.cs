using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UniversidadMVC.Models
{
    public class Carrera
    {
        [Key]
        [Display(Name = "ID")]
        public int Id { get; set; }
        [Display(Name = "Categoria")]
        public string? Nombre { get; set; }
        //Aca puse un signo de pregunta, permite que materias sea null.
        public virtual ICollection<Materia>? Materias { get; set; }   
        public Carrera() { 
 
        }
        
    }
}
