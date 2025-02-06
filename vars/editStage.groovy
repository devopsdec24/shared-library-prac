               def call() {
                 sh "cat src/main/webapp/index.jsp"  
                 sh "sed -i 's/Its Tuesday/Thank God Thursday/g' src/main/webapp/index.jsp"
                 sh "cat src/main/webapp/index.jsp"
               }
