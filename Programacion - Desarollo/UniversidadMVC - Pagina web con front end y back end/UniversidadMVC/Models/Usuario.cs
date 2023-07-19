using Microsoft.AspNetCore.Identity;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Security.Principal;
using System.Text;
using System.Threading.Tasks;

namespace UniversidadMVC.Models
{
    public class Usuario:IdentityUser
    {

        public virtual ICollection<Inscripcion> Inscripciones { get; set; }

        public Usuario():base() {
            
        }

    }
  
}
