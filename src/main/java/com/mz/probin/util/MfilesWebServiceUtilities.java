package com.mz.probin.util;

//import org.springframework.beans.PropertyValue;

public class MfilesWebServiceUtilities {/*

	public String authenticationToken;

	public enum HTTPMethod {
		GET, PUT, POST, DELETE
	};

	// Constructor.
	public MfilesWebServiceUtilities() {
	}

	 *//**
     * Calls a REST endpoint in the specified URL and returns
     * the return value. Optionally deserializes it from JSON.
     * 
     * @param <T>      The type of the return value
     * @param strUrl   URL relative to the applet root
     * @param method   HTTP Method used in the request
     * @param body     Body serialized for the JSON
     * @param output   The type of the return value
     * @return         The REST response as an instance of type T
     *//*
	public <T> T doMethod(String strUrl, HTTPMethod method, Object body,
			Class<T> output) throws IOException {
		return doMethod(strUrl, method, body, output);
	}

	   *//**
     * Calls a REST endpoint in the specified URL and returns
     * the return value. Optionally deserializes it from JSON.
     * 
     * @param <T>      The type of the return value
     * @param strUrl   URL relative to the applet root
     * @param method   HTTP Method used in the request
     * @param body     Body serialized for the JSON
     * @param output   The type of the return value
     * @param headers  Key-Value list of additional headers.
     * @return         The REST response as an instance of type T
     *//*

	@SuppressWarnings("unchecked")
	public <T> T doMethod(String strUrl, HTTPMethod method, Object body,
			Class<T> output, Map<String, String> headers) throws IOException {

		// Strip the first '/' away if it exists.
		if (strUrl.startsWith("/")) {
			strUrl = strUrl.substring(1);
		}

		// Calculate the real url based on method. IIS supports only the
		// GET and POST in default mode so we'll use the _method parameter
		// that MFWS understands.
		if (method != HTTPMethod.GET && method != HTTPMethod.POST) {
			String methodParam;
			if (strUrl.contains("?")) {
				methodParam = "&_method=";
			} else {
				methodParam = "?_method=";
			}
			strUrl += methodParam + method.name();
			method = HTTPMethod.POST;
		}

		// Initialize JSON (de)serializer.
		ObjectMapper om = new ObjectMapper();
		om.configure(
				org.codehaus.jackson.map.SerializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS,
				false);
		om.configure(
				org.codehaus.jackson.map.DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS,
				false);
		om.configure(
				org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);

		// Get URL to REST interface.
		URL u = new URL(strUrl);

		// Perform the request.
		HttpURLConnection conn = null;
		OutputStream os = null;
		InputStream is = null;
		BufferedReader in = null;
		try {

			// Open connection.
			conn = (HttpURLConnection) u.openConnection();

			// Prevent the use of cache.
			// The applet does not seem to respect the cache control flags it
			// receives from the server.
			// For example it won't necessarily make a new request to the server
			// even if the requested
			// resources has expired. See issue: #9234.
			conn.setUseCaches(false);

			// Set the request properties.
			conn.setRequestMethod(method.name());
			if (body != null)
				conn.setDoOutput(true);
			if (!output.equals(void.class))
				conn.setDoInput(true);

			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("X-AuthenticationUtils", authenticationToken);

			if (headers != null) {
				for (Map.Entry<String, String> header : headers.entrySet()) {
					System.out.println("Setting header " + header.getKey());
					conn.setRequestProperty(header.getKey(), header.getValue());
				}
			}

			// If there is a body, serialize it to the output stream.
			if (body != null) {

				os = conn.getOutputStream();
				om.writeValue(os, body);

			} else if (method != HTTPMethod.GET) {

				// No body available.
				conn.setRequestProperty("Content-Length", "0");
			}

			// Check if the caller wanted the connection as the return value.
			if (output.equals(HttpURLConnection.class)) {
				// Change ownership so we don't disconnect the connection in
				// finalize block.
				HttpURLConnection connDetached = conn;
				conn = null;
				return (T) connDetached;
			}

			// Write the output if we had output.
			if (os != null) {
				os.flush();
				os.close();
			}
			os = null;

			// Get response to input stream.
			conn.connect();
			is = conn.getInputStream();

			int contentLength = conn.getContentLength();
			if (output.equals(InputStream.class)) {
				// If the output type is input stream, just return it
				// as it is.
				InputStream isReturn = is;
				is = null; // Change ownership.
				return (T) isReturn;
			} else {

				// Deserialize from JSON object.
				String response = readStringFromStream(is, contentLength);

				// Read the return value from the response.
				if (output.equals(void.class) || response.length() == 0)
					return null;
				else
					return om.readValue(response, output);

			} // end-if (output.equals(InputStream.class))

		} catch (IOException e3) {
			throw new RuntimeException(e3);
		} finally {
			// Close streams.
			closeStream(os);
			closeStream(is);
			closeStream(in);

			if (conn != null)
				conn.disconnect();
		}
	}

	*//**
	 * Reads an UTF-8 encoded string from the specified stream.
	 * 
	 * @param is
	 * @param lengt
	 * @return
	 * @throws IOException
	 *//*

	private String readStringFromStream(InputStream is, int totalLengthInBytes)
			throws IOException {
		// Return empty string if the requested number of bytes is zero.
		if (totalLengthInBytes == 0)
			return "";

		// It seems that Opera 10 may pass -1 as the total length if the actual
		// Content-Length header
		// indicates zero body length.
		// Because -1 indicates unspecified content length we attempt to read as
		// much as possible in this case.
		if (totalLengthInBytes == -1)
			totalLengthInBytes = Integer.MAX_VALUE;

		// Read the data from the stream as bytes and pipe it through piped
		// stream
		// that converts the byte stream to UTF-8 char stream.
		PipedOutputStream poutput = null;
		PipedInputStream pinput = null;
		StringBuilder result = new StringBuilder();
		try {
			// Start reading the stream.
			boolean continueRead = true;
			poutput = new PipedOutputStream();
			pinput = new PipedInputStream(poutput);
			InputStreamReader r = new InputStreamReader(pinput, "UTF-8");
			int bytesReadTotal = 0;
			int byteBufferSize = 500; // Buffer size used in the conversion.
			CharBuffer cb = CharBuffer.allocate(byteBufferSize);
			byte[] buffer = new byte[byteBufferSize];
			while (continueRead) {
				// Read correct number of bytes from the input stream and write
				// the to the output buffer.
				int readByteCount = Math.min(buffer.length, totalLengthInBytes
						- bytesReadTotal);
				int bytesRead = is.read(buffer, 0, readByteCount);

				// Convert the bytes to a string.
				if (bytesRead > 0) {
					// Write to the piped stream.
					poutput.write(buffer, 0, bytesRead);

					// Read the bytes as string.
					cb.clear();
					r.read(cb);
					int charactersRead = cb.position();

					// Collect the string read to the buffer.
					cb.rewind();
					String currentBatch = cb.subSequence(0, charactersRead)
							.toString();
					result.append(currentBatch);

				} // end if

				// Stop reading if EOF was encountered.
				if (bytesRead == -1)
					continueRead = false;
				else
					bytesReadTotal += bytesRead;

				// Stop reading the stream after we have read all the available
				// bytes.
				if (bytesReadTotal == totalLengthInBytes)
					continueRead = false;

			} // end while
		} finally {
			// Close the middleware streams.
			closeStream(poutput);
			closeStream(pinput);
		}

		// Return the result.
		return result.toString();
	}

	*//**
	 * Closes the specified stream
	 * 
	 * @param stream
	 *//*
	private static void closeStream(Closeable stream) {
		// Try closing only if the stream was specified.
		if (stream != null) {
			try {
				stream.close();
			} catch (IOException e) {
				// Ignore error.
				e.printStackTrace();
			}
		}
	}

	// ! Specifies the information required when creating a new object.
	public class ObjectCreationInfo {

	// ! Properties for the new object.
	public PropertyValue[] PropertyValues;

	// ! References previously uploaded files.
	public UploadInfo[] Files;

	}

	 ! Contains the information on a temporary upload. 
	public class UploadInfo {

		// ! Temporary upload ID given by the server.
		public int UploadID;

		// ! File name without extension.
		public String Title;

		// ! File extension.
		public String Extension;

		// ! File size.
		public long Size;

	}

	// ! A &#39;typed value&#39; represents a value, such as text, number, date
	// or lookup item.
	public class TypedValue {

		// ! Specifies the type of the value.
		public int DataType;

		// ! Specifies whether the typed value contains a real value.
		public boolean HasValue;

		// ! Specifies the string, number or boolean value when the DataType is
		// not a lookup type.
		public Object Value;

		// ! Specifies the lookup value when the DataType is Lookup.
		public Lookup Lookup;

		// ! Specifies the collection of \type{Lookup}s when the DataType is
		// MultiSelectLookup.
		public Lookup[] Lookups;

		// ! Provides the value formatted for display.
		public String DisplayValue;

		// ! Provides a key that can be used to sort \type{TypedValue}s
		public String SortingKey;

		// ! Provides the typed value in a serialized format suitable to be used
		// in URIs.
		public String SerializedValue;

	}




	// ! AuthenticationUtils details.
	public class AuthenticationUtils {

		// !
		public String Username;

		// !
		public String Password;

		// !
		public String Domain;

		// !
		public boolean WindowsUser;

		// !
		public String ComputerName;

		// !
		public String VaultGuid;

		// !
		public String Expiration;

		// !
		public boolean ReadOnly;

		// !
		public String URL;

		// !
		public String Method;

	}

	// ! Vault information.
	public class Vault {

		// ! Vault name.
		public String Name;

		// ! Vault GUID.
		public String GUID;

		// ! Vault-specific authentication token.
		public String AuthenticationUtils;

	}

	// ! Information required for changing password.
	public class PasswordChange {

		// ! The current password.
		public String OldPassword;

		// ! The new password.
		public String NewPassword;

	}

	// ! Server public key information.
	public class PublicKey {

		// ! Base64URL encoded exponent.
		public String Exponent;

		// ! Base64URL encoded modulus.
		public String Modulus;

	}

	// ! Response for status requests.
	public class StatusResponse {

		// ! The result of the status request.
		public boolean Successful;

		// ! Display message for the status.
		public String Message;

	}

	// ! An object class with extended properties. Inherits from ObjectClass.
	public class ExtendedObjectClass {

		// ! Property definitions associated with this class.
		public AssociatedPropertyDef[] AssociatedPropertyDefs;

		// ! Templates available for use with this class.
		public ObjectVersion[] Templates;

	}

	// ! Workflow state information.
	public class WorkflowState {

		// ! Workflow state name.
		public String Name;

		// ! Workflow state ID.
		public int ID;

		// ! Defines whether this state is selectable for the current object.
		public boolean Selectable;

	}

	// ! An object version with extended properties. Inherits from
	// ObjectVersion.
	public class FolderContentItems {

		// ! The path to the current folder.
		public String Path;

		// ! Specifies whether there are more results in the folder.
		public boolean MoreResults;

		// ! The actual folder contents.
		public FolderContentItem[] Items;

	}

	// ! A workflow state on an object.
	public class ObjectWorkflowState {

		// ! The workflow state defined as a property value.
		public PropertyValue State;

		// ! The workflow state ID.
		public int StateID;

		// ! The workflow state name.
		public String StateName;

		// ! The workflow defined as a property value.
		public PropertyValue Workflow;

		// ! The workflow ID.
		public int WorkflowID;

		// ! The workflow name.
		public String WorkflowName;

		// ! Version comment defined on the workflow transition.
		public String VersionComment;

	}

	// ! M-Files Web Service error object.
	public class WebServiceError {

		// ! HTTP Status code
		public int Status;

		// ! The request URL which caused this error.
		public String URL;

		// ! The request method.
		public String Method;

		// ! Detailed information on the exception.
		public ExceptionInfo Exception;

	}

	// !
	public class ExceptionInfo {

		// ! Error message.
		public String Message;

		// ! Underlying error that caused this one.
		public ExceptionInfo InnerException;

		// ! M-Files Web Service server-side stack trace.
		public StackTraceElement[] Stack;

	}

	// ! M-Files Web Service error stack trace element.
	public class StackTraceElement {

		// !
		public String FileName;

		// !
		public int LineNumber;

		// !
		public String ClassName;

		// !
		public String MethodName;

	}

	// ! Results of a query which might leave only a partial set of items.
	public class Results<T> {

		// ! Contains results of a query
		public T[] Items;

		// ! True if there were more results which were left out.
		public boolean MoreResults;

	}

	// !
	public class PrimitiveType<T> {

		// ! Primitive value.
		public T Value;

	}

	// ! Based on M-Files API.
	public class ObjectVersion {

		// ! Based on M-Files API.
		public String AccessedByMeUtc;

		// ! Based on M-Files API.
		public String CheckedOutAtUtc;

		// ! Based on M-Files API.
		public int CheckedOutTo;

		// ! Based on M-Files API.
		public String CheckedOutToUserName;

		// ! Based on M-Files API.
		public int Class;

		// ! Based on M-Files API.
		public String CreatedUtc;

		// ! Based on M-Files API.
		public boolean Deleted;

		// ! Based on M-Files API.
		public String DisplayID;

		// ! Based on M-Files API.
		public ObjectFile[] Files;

		// ! Based on M-Files API.
		public boolean HasAssignments;

		// ! Based on M-Files API.
		public boolean HasRelationshipsFromThis;

		// ! Based on M-Files API.
		public boolean HasRelationshipsToThis;

		// ! Based on M-Files API.
		public boolean IsStub;

		// ! Based on M-Files API.
		public String LastModifiedUtc;

		// ! Based on M-Files API.
		public boolean ObjectCheckedOut;

		// ! Based on M-Files API.
		public boolean ObjectCheckedOutToThisUser;

		// ! Based on M-Files API.
		public int ObjectVersionFlags;

		// ! Based on M-Files API.
		public ObjVer ObjVer;

		// ! Based on M-Files API.
		public boolean SingleFile;

		// ! Based on M-Files API.
		public boolean ThisVersionLatestToThisUser;

		// ! Based on M-Files API.
		public String Title;

		// ! Based on M-Files API.
		public boolean VisibleAfterOperation;

	}

	// ! Based on M-Files API.
	public class ObjectFile {

		// ! Based on M-Files API.
		public String ChangeTimeUtc;

		// ! Based on M-Files API.
		public String Extension;

		// ! Based on M-Files API.
		public int ID;

		// ! Based on M-Files API.
		public String Name;

		// ! Based on M-Files API.
		public int Version;

	}

	// ! Based on M-Files API.
	public class ObjVer {

		// ! Based on M-Files API.
		public int ID;

		// ! Based on M-Files API.
		public int Type;

		// ! Based on M-Files API.
		public int Version;

	}

	// ! Based on M-Files API.
	public class PropertyValue {

		// ! Based on M-Files API.
		public int PropertyDef;

		// ! Based on M-Files API.
		public TypedValue TypedValue;

	}

	// ! Based on M-Files API.
	public class SessionInfo {

		// ! Based on M-Files API.
		public String AccountName;

		// ! Based on M-Files API.
		public int ACLMode;

		// ! Based on M-Files API.
		public int AuthenticationType;

		// ! Based on M-Files API.
		public boolean CanForceUndoCheckout;

		// ! Based on M-Files API.
		public boolean CanManageCommonUISettings;

		// ! Based on M-Files API.
		public boolean CanManageCommonViews;

		// ! Based on M-Files API.
		public boolean CanManageTraditionalFolders;

		// ! Based on M-Files API.
		public boolean CanMaterializeViews;

		// ! Based on M-Files API.
		public boolean CanSeeAllObjects;

		// ! Based on M-Files API.
		public boolean CanSeeDeletedObjects;

		// ! Based on M-Files API.
		public boolean InternalUser;

		// ! Based on M-Files API.
		public boolean LicenseAllowsModifications;

		// ! Based on M-Files API.
		public int UserID;

	}

	// ! Based on M-Files API.
	public class ObjType {

		// ! Based on M-Files API.
		public boolean AllowAdding;

		// ! Based on M-Files API.
		public boolean CanHaveFiles;

		// ! Based on M-Files API.
		public int DefaultPropertyDef;

		// ! Based on M-Files API.
		public boolean External;

		// ! Based on M-Files API.
		public int ID;

		// ! Based on M-Files API.
		public String NamePlural;

		// ! Based on M-Files API.
		public String Name;

		// ! Based on M-Files API.
		public int OwnerPropertyDef;

		// ! Based on M-Files API.
		public int[] ReadOnlyPropertiesDuringInsert;

		// ! Based on M-Files API.
		public int[] ReadOnlyPropertiesDuringUpdate;

		// ! Based on M-Files API.
		public boolean RealObjectType;

	}

	// ! Based on M-Files API.
	public class PropertyDef {

		// ! Based on M-Files API.
		public boolean AllObjectTypes;

		// ! Based on M-Files API.
		public String AutomaticValue;

		// ! Based on M-Files API.
		public int AutomaticValueType;

		// ! Based on M-Files API.
		public boolean BasedOnValueList;

		// ! Based on M-Files API.
		public int DataType;

		// ! Based on M-Files API.
		public int ID;

		// ! Based on M-Files API.
		public String Name;

		// ! Based on M-Files API.
		public int ObjectType;

		// ! Based on M-Files API.
		public int ValueList;

	}

	// ! Based on M-Files API.
	public class Workflow {

		// ! Based on M-Files API.
		public int ID;

		// ! Based on M-Files API.
		public String Name;

		// ! Based on M-Files API.
		public int ObjectClass;

	}

	// ! Based on M-Files API.
	public class ValueListItem {

		// ! Based on M-Files API.
		public String DisplayID;

		// ! Based on M-Files API.
		public boolean HasOwner;

		// ! Based on M-Files API.
		public boolean HasParent;

		// ! Based on M-Files API.
		public int ID;

		// ! Based on M-Files API.
		public String Name;

		// ! Based on M-Files API.
		public int OwnerID;

		// ! Based on M-Files API.
		public int ParentID;

		// ! Based on M-Files API.
		public int ValueListID;

	}

	// ! Based on M-Files API.
	public class ObjID {

		// ! Based on M-Files API.
		public int ID;

		// ! Based on M-Files API.
		public int Type;

	}

	// ! Based on M-Files API.
	public class Lookup {

		// ! Based on M-Files API.
		public boolean Deleted;

		// ! Based on M-Files API.
		public String DisplayValue;

		// ! Based on M-Files API.
		public boolean Hidden;

		// ! Based on M-Files API.
		public int Item;

		// ! Based on M-Files API.
		public int Version;

	}

	// ! Based on M-Files API.
	public class VersionComment {

		// ! Based on M-Files API.
		public PropertyValue LastModifiedBy;

		// ! Based on M-Files API.
		public ObjVer ObjVer;

		// ! Based on M-Files API.
		public PropertyValue StatusChanged;

		// ! Based on M-Files API.
		public PropertyValue Comment;

	}

	// ! Based on M-Files API.
	public class AssociatedPropertyDef {

		// ! Based on M-Files API.
		public int PropertyDef;

		// ! Based on M-Files API.
		public boolean Required;

	}

	// ! Based on M-Files API.
	public class FolderContentItem {

		// ! Based on M-Files API.
		public int FolderContentItemType;

		// ! Based on M-Files API.
		public ObjectVersion ObjectVersion;

		// ! Based on M-Files API.
		public TypedValue PropertyFolder;

		// ! Based on M-Files API.
		public Lookup TraditionalFolder;

		// ! Based on M-Files API.
		public View View;

	}

	// ! Based on M-Files API.
	public class View {

		// ! Based on M-Files API.
		public boolean Common;

		// ! Based on M-Files API.
		public int ID;

		// ! Based on M-Files API.
		public String Name;

		// ! Based on M-Files API.
		public int Parent;

		// ! Based on M-Files API.
		public ViewLocation ViewLocation;

	}

	// ! Based on M-Files API.
	public class ViewLocation {

		// ! Based on M-Files API.
		public TypedValue OverlappedFolder;

		// ! Based on M-Files API.
		public boolean Overlapping;

	}

	// ! Based on M-Files API.
	public class ObjectClass {

		// ! Based on M-Files API.
		public int ID;

		// ! Based on M-Files API.
		public String Name;

		// ! Based on M-Files API.
		public int NamePropertyDef;

		// ! Based on M-Files API.
		public int Workflow;

	}

	// ! Based on M-Files API.
	public class ClassGroup {

		// ! Based on M-Files API.
		public String Name;

	}

	// !
	public class MFCheckOutStatus {

		// ! Object is checked in.
		int CheckedIn = 0;

		// ! Object is checked out to someone else.
		int CheckedOut = 1;

		// ! Object is checked out to the current user.
		int CheckedOutToMe = 2;

	}

	// !
	public class MFRefreshStatus {

		// !
		int None = 0;

		// !
		int Quick = 1;

		// !
		int Full = 2;

	}

	// !
	public class MFObjectVersionFlag {

		// !
		int None = 0;

		// !
		int Completed = 1;

		// !
		int HasRelatedObjects = 2;

	}

	// !
	public class MFAuthType {

		// !
		int Unknown = 0;

		// !
		int LoggedOnWindowsUser = 1;

		// !
		int SpecificWindowsUser = 2;

		// !
		int SpecificMFilesUser = 3;

	}

	// !
	public class MFACLMode {

		// !
		int Simple = 0;

		// !
		int AutomaticPermissionsWithComponents = 1;

	}

	// !
	public class MFDataType {

		// !
		int Uninitialized = 0;

		// !
		int Text = 1;

		// !
		int Integer = 2;

		// !
		int Floating = 3;

		// !
		int Date = 5;

		// !
		int Time = 6;

		// !
		int Timestamp = 7;

		// !
		int Boolean = 8;

		// !
		int Lookup = 9;

		// !
		int MultiSelectLookup = 10;

		// !
		int Integer64 = 11;

		// !
		int FILETIME = 12;

		// !
		int MultiLineText = 13;

		// !
		int ACL = 14;

	}

	// !
	public class MFAutomaticValueType {

		// !
		int None = 0;

		// !
		int CalculatedWithPlaceholders = 1;

		// !
		int CalculatedWithVBScript = 2;

		// !
		int AutoNumberSimple = 3;

		// !
		int WithVBScript = 4;

	}

	// !
	public class MFFolderContentItemType {

		// !
		int Unknown = 0;

		// !
		int ViewFolder = 1;

		// !
		int PropertyFolder = 2;

		// !
		int TraditionalFolder = 3;

		// !
		int ObjectVersion = 4;
	}

*/}
