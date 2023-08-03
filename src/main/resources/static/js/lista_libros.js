
    const borrar= async (book)=>{
        console.log(book);
        let isExecuted = confirm("Are you sure to execute Borrar el libro?");

        if(isExecuted == false )return;

        let respuesta = await fetch("/api/books/"+book,{ method:"DELETE" })
        .then((response) => {
           //console.log(response);
           return response.ok;
        }).catch(err => {
          console.log(err);
          return err;
        });

        if(respuesta == true)location.reload();
        if(respuesta != true){alert("Upps...");};
    }

    const cargarModal = async (id_libro)=>{
        //alert("cargarModal"+ id_libro );
        let respuesta = await fetch(`/api/books/${id_libro}`, { method:"GET", } )
        .then((response) => {
            if(response.ok){
                return response.json().then(data => { return data });
           }else{
                throw Error(response.statusText);
                return null;
           }
        })
        .catch(err => {
            console.log(err);
            return err;
        });

        if( respuesta != null){
            $('#title').val(respuesta.title);
            $('#author').val(respuesta.author);
            $('#id_libro').val(respuesta.id);
        }
    }

    const enviarUpdateLibro=async()=>{
        let tituleInputId = '#titulo_'+$('#id_libro').val();
        let authorInputId = '#author'+$('#id_libro').val();
        let objBook = {
            id:$('#id_libro').val(),
            title:$('#title').val(),
            author:$('#author').val()
        }
        let respuesta = await fetch("/api/books/"+$('#id_libro').val(), {
            method:"PUT",
            headers:{"Content-Type":"application/json"},
            body: JSON.stringify(objBook)
        })
        .then((response)=>{
            console.log(response);
            if(response.ok){
                return response.json().then(data => { return data });
           }else{
                throw Error(response.statusText);
                console.log(response);
                return null;
           }
        })
        .catch(err => {
            console.log(err);
            return err;
        });
        $(authorInputId).text( "Author: " + $('#author').val() );
        $(tituleInputId).text( $('#title').val() );
    }

    const enviarNuevoLibro=async()=>{
        //alert("enviarNuevoLibro");
        let objBook = {
            title: $('#agregar_title').val(),
            author: $('#agregar_author').val()
        }
        let respuesta = await fetch("/api/books", {
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body: JSON.stringify(objBook)
        })
        .then((response)=>{
            //console.log(response);
            if(response.ok){
                //return response.json().then(data => { return data });
                return response.ok;
           }else{
                throw Error(response.statusText);
                console.log(response);
                return null;
           }
        })
        .catch(err => {
            console.log(err);
            return err;
        });
        //console.log("respuesta")
        //console.log(respuesta)
        if(respuesta){
            location.reload(true);
        }
    }




        /***** /
          fetch("/api/books",{
             method:"GET",
          }).then((response) => {
               response.json().then(data => {
                   console.log(data);
               });
           }).catch(err => {
              console.log(err);
           });
        / ******/

        /*******
        let fetchConfig = {
                    method : 'GET'
                };
        fetch("/api/books",fetchConfig).then(function (response) {
            if (!response.ok) {
                console.log("error");
                throw Error(response.statusText);
            }
            else {
                console.log(response.json());
            }
        }).then(function (data) {
           console.log("data");
           console.log(data);
        }).catch(function (error) {
           console.log("error");
           console.log(error);
        })
        *******/
    /******
    let sendData = "this is data";
    fetch("/api/books",{
                 method:"POST",
                 headers:{"Content-Type":"application/json"},
                 body: JSON.stringify({"some_data": sendData})
              }).then((response) => {
                   response.json().then(data => {
                       console.log(data);
                   });
               }).catch(err => {
                  console.log(err);
               });

    *****/