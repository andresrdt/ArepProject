/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var modulo = (function () {
    var datosEmp = [0,0,0,0];
    var getEmpresasByService = function (servicio) {
        var getPromise = $.get("/datos/" + servicio);

        getPromise.then(
                function (data) {
                    
                    if (servicio === "AWS"){
                        datosEmp[0]=data.length
                    }
                    else if (servicio === "Microsoft AZURE"){
                        datosEmp[2]=data.length
                    }
                    else if (servicio === "GOOGLE CLOUD PLATAFORM"){
                        datosEmp[1]=data.length
                    }
                },
                function () {
                    console.log('get failed');
                }
        );

        return getPromise;
    };

    var getEmpresas = function () {
        var getPromise = $.get("/datos/empresas");

        getPromise.then(
                function (data) {
                    alert(data.length)
                    getPromise = data.length;
                    datosEmp[3]=data.length;
                    datos();
                },
                function () {
                    console.log('get failed');
                }
        );

        return getPromise;
    };
    
    var lleneDatos = function () {
        
        var aws = getEmpresasByService("AWS");
        var azure = getEmpresasByService("Microsoft AZURE");
        var google = getEmpresasByService("GOOGLE CLOUD PLATAFORM");
        var otros = getEmpresas();
        
        //datosEmp.push();
    }
    var datos = function () {
        var densityCanvas = document.getElementById("densityChart");
        Chart.defaults.global.defaultFontFamily = "Lato";
        Chart.defaults.global.defaultFontSize = 18;
        
        datosEmp.push(0);
        var densityData = {
            label: 'Cantidad de empresas',
            data: datosEmp,
            backgroundColor: [
                'rgba(255, 206, 86, 0.6)',
                'rgba(62, 149, 75, 0.6)',
                'rgba(68, 96, 180, 0.6)',
                'rgba(75, 192, 192, 0.6)'
            ]
        };

        var barChart = new Chart(densityCanvas, {
            type: 'bar',
            borderColor: 'rgb(255, 99, 132)',
            data: {
                labels: ["Amazon Web Services", "Google Cloud", "Microsoft Azure", "Otros"],
                datasets: [densityData]

            }

        });
    }

    return {
        cargarDatos:lleneDatos
    };
})();