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
    public partial class ESOWindow : Form
    {
        ESOGen generator = new ESOGen();

        public ESOWindow()
        {
            InitializeComponent();
        }

        private void chkARAF_CheckedChanged(object sender, EventArgs e)
        {
            generator.araf = chkARAF.Checked;
        }

        private void chkImperial_CheckedChanged(object sender, EventArgs e)
        {
            generator.imperial = chkImperial.Checked;
        }

        private void btnGenerate_Click(object sender, EventArgs e)
        {
            generator.randomCharacter();
            lblFaction.Text = generator.character.faction;
            lblRace.Text = generator.character.race;
            lblClass.Text = generator.character.charClass;
        }
    }
}
