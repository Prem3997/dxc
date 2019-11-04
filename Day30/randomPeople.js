function randomBool() {
	var bool = true; 
	var random_boolean = Math.random() >= 0.95; 
	if(random_boolean) 
	{ 
		bool = false 
	}; 
	return bool; 
}
