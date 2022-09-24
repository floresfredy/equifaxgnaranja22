google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        $.ajax({
          url: "api/equifax/deudaTotal",
          dataType: "json",
        }).done(function (jsonData) {
          var data = new google.visualization.DataTable();
          data.addColumn('string', 'nombre');
          data.addColumn('number', 'deudaTotal');
          
  
          jsonData.forEach(function (row) {
            data.addRow([
              row.nombre,
              row.deudaTotal
            ]);
          });
  
          var options = {
            chart: {
              title: 'Deudas',
              subtitle: 'Deudas de las personas',
            }
          };
  
          
          var chart = new google.charts.Bar(document.getElementById('columnchart_material'));
          chart.draw(data, google.charts.Bar.convertOptions(options));
        }).fail(function (jq, text, err) {
          console.log(text + ' - ' + err);
        });
  }