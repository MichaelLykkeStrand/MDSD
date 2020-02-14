/*
CWaos/reviews/Copyright (c) 2017, Ulrik Pagh Schultz, University of Southern Denmark
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met: 

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer. 
2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution. 

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

The views and conclusions contained in the software and documentation are those
of the authors and should not be interpreted as representing official policies, 
either expressed or implied, of the University of Southern Denmark.
*/
package examples.misc;

public class EntitiesMethodChainWithConstraints {
	
	public void build() {
		system().
			entity("Person").
				field(String.class,"name").
				field(Integer.class, "age").
				attribute("Person","friends","*").inverse("maybe_friend","*").
			entity("Student", "Person").
				field(String.class, "id").
			entity("Teacher", "Person").
				field(String.class, "title");
	}
	
	// Builder definitions, placed in this class to show declarations, place elsewhere in real system
	
	private interface Builder {
		EntityBuilder entity(String name);
		EntityBuilder entity(String name, String base);
	}
	private interface EntityBuilder extends Builder {
		EntityBuilder field(Class<? extends Object> type, String name);
		RelationBuilder attribute(String type, String name, String multiplicity);
	}
	private interface RelationBuilder extends Builder {
		EntityBuilder inverse(String name, String multiplicity);
	}
	static Builder system() { return null; }
}
