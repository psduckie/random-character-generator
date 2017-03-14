using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CharGen
{
    public partial class STOWindow : Form
    {
        STOGen generator = new STOGen();

        public STOWindow()
        {
            InitializeComponent();
        }

        private void btnGenerate_Click(object sender, EventArgs e)
        {
            generator.randomCharacter();
            lblFaction.Text = generator.character.faction;
            lblShip.Text = generator.character.shipClass;
            lblClass.Text = generator.character.charClass;
        }
    }
}
