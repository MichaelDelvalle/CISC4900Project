<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            body {
                margin: 0;
                padding: 0;
                background: #ccc;
            }

            .nav ul {
                list-style: none;
                background-color: #444;
                text-align: center;
                padding: 0;
                margin: 0;
            }
            .nav li {
                font-family: 'Oswald', sans-serif;
                font-size: 1.2em;
                line-height: 40px;
                height: 40px;
                border-bottom: 1px solid #888;
            }

            .nav a {
                text-decoration: none;
                color: #fff;
                display: block;
                transition: .3s background-color;
            }

            .nav a:hover {
                background-color: #005f5f;
                text-decoration: underline;
            }


            @media screen and (min-width: 600px) {
                .nav li {
                    width: 120px;
                    border-bottom: none;
                    height: 50px;
                    line-height: 50px;
                    font-size: 15px;
                }

                /* Option 1 - Display Inline */
                .nav li {
                    display: inline-block;
                    margin-right: -4px;
                }
            </style>
            <header>
                <div id="header_navigation_bar" class="nav">
                    <ul>
                        <!--fill code here(for navigation bar)-->
                 	<li class = "inline2">
						<a href="userinfo">My Profile</a>
					</li>	
				<li>
					<li class = "inline3">
							<a href="logout">Logout</a>
					</li>
                    </ul>
                </div>
            </header>
