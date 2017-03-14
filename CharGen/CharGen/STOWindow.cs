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
            if (cboTypeOfPick.SelectedIndex == 0) // Random faction
                generator.randomCharacter();
            else if (cboTypeOfPick.SelectedIndex == 1) // Specific alingment
            {
                if (cboAlignmentPick.SelectedIndex == 0) // Fed aligned
                    generator.randomCharacter('F');
                else if (cboAlignmentPick.SelectedIndex == 1) // KDF aligned
                    generator.randomCharacter('K');
            }
            else if (cboTypeOfPick.SelectedIndex == 2) // Specific faction
                generator.randomCharacter(cboFactionPick.SelectedIndex);

            lblFaction.Text = generator.character.faction;
            lblShip.Text = generator.character.shipClass;
            lblClass.Text = generator.character.charClass;
        }

        private void STOWindow_Load(object sender, EventArgs e)
        {
            cboTypeOfPick.SelectedIndex = 0;
            cboAlignmentPick.SelectedIndex = 0;
            cboFactionPick.SelectedIndex = 0;
        }

        private void cboTypeOfPick_SelectedIndexChanged(object sender, EventArgs e)
        {
            if(cboTypeOfPick.SelectedIndex == 1) // Specific alignment
            {
                lblAlignmentPick.Visible = true;
                cboAlignmentPick.Visible = true;
            }
            else
            {
                lblAlignmentPick.Visible = false;
                cboAlignmentPick.Visible = false;
            }

            if (cboTypeOfPick.SelectedIndex == 2) // Specific faction
            {
                lblFactionPick.Visible = true;
                cboFactionPick.Visible = true;
            }
            else
            {
                lblFactionPick.Visible = false;
                cboFactionPick.Visible = false;
            }

        }
    }
}
