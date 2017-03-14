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
    public partial class MainWindow : Form
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void btnESO_Click(object sender, EventArgs e)
        {
            ESOWindow newWindow = new ESOWindow();
            newWindow.Show();
        }

        private void btnSTO_Click(object sender, EventArgs e)
        {
            STOWindow newWindow = new STOWindow();
            newWindow.Show();
        }
    }
}
