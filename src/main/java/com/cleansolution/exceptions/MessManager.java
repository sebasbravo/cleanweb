package com.cleansolution.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MessManager extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(MessManager.class);
	public final static String ALL = "All ";
	public final static String ID = "Id ";
	public final static String ENTCHILD = "related tables(childs)";
	public final static String FOREIGNDATA = "foreign classes data: ";
	public static String ENTITY_SUCCESFULLYSAVED = "Entity succesfully saved";
	public static String ENTITY_SUCCESFULLYDELETED = "Entity succesfully deleted";
	public static String ENTITY_SUCCESFULLYMODIFIED = "Entity succesfully modified";
	public static String ENTITY_WITHSAMEKEY = "Another Entity with the same key was found";
	public static String ENTITY_NOENTITYTOUPDATE = "No Entity was found, with the typed key ";

	public MessManager() {
		super();
	}

	public MessManager(String exception) {
		super(exception);
	}

	public class NotValidFieldException extends MessManager {
		private static final long serialVersionUID = 1L;

		public NotValidFieldException(String info) {
			super("The value for the field: \"" + info + "\" is not valid");
		}
	}

	public class NullEntityExcepcion extends MessManager {
		private static final long serialVersionUID = 1L;

		public NullEntityExcepcion(String info) {
			super("The " + info + " Entity can not be null or empty");
		}
	}

	public class EmptyFieldException extends MessManager {
		private static final long serialVersionUID = 1L;

		public EmptyFieldException(String info) {
			super("The value for the field: \"" + info + "\" can not be null or empty");
		}
	}

	public class NotValidFormatException extends MessManager {
		private static final long serialVersionUID = 1L;

		public NotValidFormatException(String info) {
			super("The Format or length for the field: \"" + info + "\" is not valid");
		}
	}

	public class DeletingException extends MessManager {
		private static final long serialVersionUID = 1L;

		public DeletingException(String info) {
			super("The Entity you are trying to delete " + "may have related information, "
					+ "please before trying again, " + "check the data on the entity, \"" + info + "\"");
		}
	}

	public class ForeignException extends MessManager {
		private static final long serialVersionUID = 1L;

		public ForeignException(String info) {
			super("There was no data related with the input \"" + info + "\"");
		}
	}

	public class GettingException extends MessManager {
		private static final long serialVersionUID = 1L;

		public GettingException(String info) {
			super("There was an exception getting " + info);
		}
	}

	public class FindingException extends MessManager {
		private static final long serialVersionUID = 1L;

		public FindingException(String info) {
			super("There was an exception trying to find " + info);
		}
	}
}
