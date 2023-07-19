using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UniversidadMVC.Models
{
    public class Inscripcion
    {
        [Key]
        public int Id { get; set; }
        public virtual Usuario Usuario { get; set; }       
        public virtual ICollection<Materia> Materias { get; set; } 

        public Inscripcion() {       
        
        }    

    }
}
